package com.lacosina.api.Token;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    @Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    @Resource(name = "tokenStore")
    private TokenStore tokenStore;

    @PostMapping("/oauth/token/revokeById/{tokenId}")
    @ResponseBody
    public void revokeToken(HttpServletRequest request, @PathVariable String tokenId) {
        tokenServices.revokeToken(tokenId);
    }

    @GetMapping("/tokens")
    @ResponseBody
    public List<String> getTokens() {
        Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("sampleClientId");
        return Optional.ofNullable(tokens)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(OAuth2AccessToken::getValue)
                    .collect(Collectors.toList());
    }

    @PostMapping("/tokens/revokeRefreshToken/{tokenId:.*}")
    @ResponseBody
    public String revokeAccessToken(@PathVariable String tokenId) {
        if (tokenStore instanceof JdbcTokenStore) {
            ((JdbcTokenStore) tokenStore).removeRefreshToken(tokenId);
        }

        return tokenId;
    }

}

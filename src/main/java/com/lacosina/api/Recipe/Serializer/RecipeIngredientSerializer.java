package com.lacosina.api.Recipe.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lacosina.api.Recipe.Recipe;
import com.lacosina.api.Recipe.RecipeIngredient;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RecipeIngredientSerializer extends StdSerializer<Set<RecipeIngredient>> {

    public RecipeIngredientSerializer() {
        this(null);
    }

    public RecipeIngredientSerializer(Class<Set<RecipeIngredient>> t) {
        super(t);
    }

    @Override
    public void serialize(
            Set<RecipeIngredient> recipeIngredients,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    ) throws IOException {

    }
}

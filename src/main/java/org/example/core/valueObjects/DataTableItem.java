package org.example.core.valueObjects;

import org.example.core.pages.FormPage;

import java.util.stream.Stream;

public record DataTableItem(String email, String name, FormPage.Gender gender, FormPage.CheckBoxVariant checkBoxVariant,
                            FormPage.RadioButtonVariant radioButtonVariant) {
    @Override
    public String toString() {
       return String.join(
                " ",
                Stream.of(
                        email,
                        name,
                        gender.getLabel(),
                        checkBoxVariant.getLabel(),
                        radioButtonVariant.getLabel()
                ).toList()
        ).trim();
    }
}

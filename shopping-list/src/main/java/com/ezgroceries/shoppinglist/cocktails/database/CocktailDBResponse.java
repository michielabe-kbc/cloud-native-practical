package com.ezgroceries.shoppinglist.cocktails.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CocktailDBResponse {

    private List<DrinkResource> drinks;

    public List<DrinkResource> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<DrinkResource> drinks) {
        this.drinks = drinks;
    }

    public static class DrinkResource {
        public String idDrink;
        public String strDrink;
        public String strDrinkAlternate;
        public String strDrinkES;
        public String strDrinkDE;
        public String strDrinkFR;
        public String strTags;
        public String strVideo;
        public String strCategory;
        public String strIBA;
        public String strAlcoholic;
        public String strGlass;
        public String strInstructions;
        public String strInstructionsES;
        public String strInstructionsDE;
        public String strInstructionsFR;
        public String strDrinkThumb;
        public String strIngredient1;
        public String strIngredient2;
        public String strIngredient3;
        public String strIngredient4;
        public String strIngredient5;
        public String strIngredient6;
        public String strIngredient7;
        public String strIngredient8;
        public String strIngredient9;
        public String strIngredient10;
        public String strIngredient11;
        public String strIngredient12;
        public String strIngredient13;
        public String strIngredient14;
        public String strIngredient15;
        public String strMeasure1;
        public String strMeasure2;
        public String strMeasure3;
        public String strMeasure4;
        public String strMeasure5;
        public String strMeasure6;
        public String strMeasure7;
        public String strMeasure8;
        public String strMeasure9;
        public String strMeasure10;
        public String strMeasure11;
        public String strMeasure12;
        public String strMeasure13;
        public String strMeasure14;
        public String strMeasure15;
        public String strCreativeCommonsConfirmed;
        public String dateModified;

        public List<String> getIngredients() {
            List<String> ingredients = new ArrayList<String>();

            if (strIngredient1 != null) {
                ingredients.add(strIngredient1);
            }
            if (strIngredient2 != null) {
                ingredients.add(strIngredient2);
            }
            if (strIngredient3 != null) {
                ingredients.add(strIngredient3);
            }
            if (strIngredient4 != null) {
                ingredients.add(strIngredient4);
            }
            if (strIngredient5 != null) {
                ingredients.add(strIngredient5);
            }
            if (strIngredient6 != null) {
                ingredients.add(strIngredient6);
            }
            if (strIngredient7 != null) {
                ingredients.add(strIngredient7);
            }
            if (strIngredient8 != null) {
                ingredients.add(strIngredient8);
            }
            if (strIngredient8 != null) {
                ingredients.add(strIngredient8);
            }

            return ingredients;
        }

        public String getIdDrink() {
            return idDrink;
        }

        public void setIdDrink(String idDrink) {
            this.idDrink = idDrink;
        }

        public String getStrDrink() {
            return strDrink;
        }

        public void setStrDrink(String strDrink) {
            this.strDrink = strDrink;
        }

        public String getStrDrinkAlternate() {
            return strDrinkAlternate;
        }

        public void setStrDrinkAlternate(String strDrinkAlternate) {
            this.strDrinkAlternate = strDrinkAlternate;
        }

        public String getStrDrinkES() {
            return strDrinkES;
        }

        public void setStrDrinkES(String strDrinkES) {
            this.strDrinkES = strDrinkES;
        }

        public String getStrDrinkDE() {
            return strDrinkDE;
        }

        public void setStrDrinkDE(String strDrinkDE) {
            this.strDrinkDE = strDrinkDE;
        }

        public String getStrDrinkFR() {
            return strDrinkFR;
        }

        public void setStrDrinkFR(String strDrinkFR) {
            this.strDrinkFR = strDrinkFR;
        }

        public String getStrTags() {
            return strTags;
        }

        public void setStrTags(String strTags) {
            this.strTags = strTags;
        }

        public String getStrVideo() {
            return strVideo;
        }

        public void setStrVideo(String strVideo) {
            this.strVideo = strVideo;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        public String getStrIBA() {
            return strIBA;
        }

        public void setStrIBA(String strIBA) {
            this.strIBA = strIBA;
        }

        public String getStrAlcoholic() {
            return strAlcoholic;
        }

        public void setStrAlcoholic(String strAlcoholic) {
            this.strAlcoholic = strAlcoholic;
        }

        public String getStrGlass() {
            return strGlass;
        }

        public void setStrGlass(String strGlass) {
            this.strGlass = strGlass;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public void setStrInstructions(String strInstructions) {
            this.strInstructions = strInstructions;
        }

        public String getStrInstructionsES() {
            return strInstructionsES;
        }

        public void setStrInstructionsES(String strInstructionsES) {
            this.strInstructionsES = strInstructionsES;
        }

        public String getStrInstructionsDE() {
            return strInstructionsDE;
        }

        public void setStrInstructionsDE(String strInstructionsDE) {
            this.strInstructionsDE = strInstructionsDE;
        }

        public String getStrInstructionsFR() {
            return strInstructionsFR;
        }

        public void setStrInstructionsFR(String strInstructionsFR) {
            this.strInstructionsFR = strInstructionsFR;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public void setStrDrinkThumb(String strDrinkThumb) {
            this.strDrinkThumb = strDrinkThumb;
        }

        public String getStrIngredient1() {
            return strIngredient1;
        }

        public void setStrIngredient1(String strIngredient1) {
            this.strIngredient1 = strIngredient1;
        }

        public String getStrIngredient2() {
            return strIngredient2;
        }

        public void setStrIngredient2(String strIngredient2) {
            this.strIngredient2 = strIngredient2;
        }

        public String getStrIngredient3() {
            return strIngredient3;
        }

        public void setStrIngredient3(String strIngredient3) {
            this.strIngredient3 = strIngredient3;
        }

        public String getStrIngredient4() {
            return strIngredient4;
        }

        public void setStrIngredient4(String strIngredient4) {
            this.strIngredient4 = strIngredient4;
        }

        public String getStrIngredient5() {
            return strIngredient5;
        }

        public void setStrIngredient5(String strIngredient5) {
            this.strIngredient5 = strIngredient5;
        }

        public String getStrIngredient6() {
            return strIngredient6;
        }

        public void setStrIngredient6(String strIngredient6) {
            this.strIngredient6 = strIngredient6;
        }

        public String getStrIngredient7() {
            return strIngredient7;
        }

        public void setStrIngredient7(String strIngredient7) {
            this.strIngredient7 = strIngredient7;
        }

        public String getStrIngredient8() {
            return strIngredient8;
        }

        public void setStrIngredient8(String strIngredient8) {
            this.strIngredient8 = strIngredient8;
        }

        public String getStrIngredient9() {
            return strIngredient9;
        }

        public void setStrIngredient9(String strIngredient9) {
            this.strIngredient9 = strIngredient9;
        }

        public String getStrIngredient10() {
            return strIngredient10;
        }

        public void setStrIngredient10(String strIngredient10) {
            this.strIngredient10 = strIngredient10;
        }

        public String getStrIngredient11() {
            return strIngredient11;
        }

        public void setStrIngredient11(String strIngredient11) {
            this.strIngredient11 = strIngredient11;
        }

        public String getStrIngredient12() {
            return strIngredient12;
        }

        public void setStrIngredient12(String strIngredient12) {
            this.strIngredient12 = strIngredient12;
        }

        public String getStrIngredient13() {
            return strIngredient13;
        }

        public void setStrIngredient13(String strIngredient13) {
            this.strIngredient13 = strIngredient13;
        }

        public String getStrIngredient14() {
            return strIngredient14;
        }

        public void setStrIngredient14(String strIngredient14) {
            this.strIngredient14 = strIngredient14;
        }

        public String getStrIngredient15() {
            return strIngredient15;
        }

        public void setStrIngredient15(String strIngredient15) {
            this.strIngredient15 = strIngredient15;
        }

        public String getStrMeasure1() {
            return strMeasure1;
        }

        public void setStrMeasure1(String strMeasure1) {
            this.strMeasure1 = strMeasure1;
        }

        public String getStrMeasure2() {
            return strMeasure2;
        }

        public void setStrMeasure2(String strMeasure2) {
            this.strMeasure2 = strMeasure2;
        }

        public String getStrMeasure3() {
            return strMeasure3;
        }

        public void setStrMeasure3(String strMeasure3) {
            this.strMeasure3 = strMeasure3;
        }

        public String getStrMeasure4() {
            return strMeasure4;
        }

        public void setStrMeasure4(String strMeasure4) {
            this.strMeasure4 = strMeasure4;
        }

        public String getStrMeasure5() {
            return strMeasure5;
        }

        public void setStrMeasure5(String strMeasure5) {
            this.strMeasure5 = strMeasure5;
        }

        public String getStrMeasure6() {
            return strMeasure6;
        }

        public void setStrMeasure6(String strMeasure6) {
            this.strMeasure6 = strMeasure6;
        }

        public String getStrMeasure7() {
            return strMeasure7;
        }

        public void setStrMeasure7(String strMeasure7) {
            this.strMeasure7 = strMeasure7;
        }

        public String getStrMeasure8() {
            return strMeasure8;
        }

        public void setStrMeasure8(String strMeasure8) {
            this.strMeasure8 = strMeasure8;
        }

        public String getStrMeasure9() {
            return strMeasure9;
        }

        public void setStrMeasure9(String strMeasure9) {
            this.strMeasure9 = strMeasure9;
        }

        public String getStrMeasure10() {
            return strMeasure10;
        }

        public void setStrMeasure10(String strMeasure10) {
            this.strMeasure10 = strMeasure10;
        }

        public String getStrMeasure11() {
            return strMeasure11;
        }

        public void setStrMeasure11(String strMeasure11) {
            this.strMeasure11 = strMeasure11;
        }

        public String getStrMeasure12() {
            return strMeasure12;
        }

        public void setStrMeasure12(String strMeasure12) {
            this.strMeasure12 = strMeasure12;
        }

        public String getStrMeasure13() {
            return strMeasure13;
        }

        public void setStrMeasure13(String strMeasure13) {
            this.strMeasure13 = strMeasure13;
        }

        public String getStrMeasure14() {
            return strMeasure14;
        }

        public void setStrMeasure14(String strMeasure14) {
            this.strMeasure14 = strMeasure14;
        }

        public String getStrMeasure15() {
            return strMeasure15;
        }

        public void setStrMeasure15(String strMeasure15) {
            this.strMeasure15 = strMeasure15;
        }

        public String getStrCreativeCommonsConfirmed() {
            return strCreativeCommonsConfirmed;
        }

        public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
            this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        }

        public String getDateModified() {
            return dateModified;
        }

        public void setDateModified(String dateModified) {
            this.dateModified = dateModified;
        }

        public List<String> getAllIngredients() {
            List<String> ingredients = new ArrayList<>(
                    Arrays.asList(
                            strIngredient1,
                            strIngredient2,
                            strIngredient3,
                            strIngredient4,
                            strIngredient5,
                            strIngredient6,
                            strIngredient7,
                            strIngredient8,
                            strIngredient9,
                            strIngredient10,
                            strIngredient11,
                            strIngredient12,
                            strIngredient13,
                            strIngredient14,
                            strIngredient15
                    ));
            ingredients.removeIf(Objects::isNull);
            return ingredients;
        }

        public void setAllIngredients(List<String> ingredients) {
            this.strIngredient1 = ingredients.size() > 0 ? ingredients.get(0) : null;
            this.strIngredient2 = ingredients.size() > 1 ? ingredients.get(1) : null;
            this.strIngredient3 = ingredients.size() > 2 ? ingredients.get(2) : null;
            this.strIngredient4 = ingredients.size() > 3 ? ingredients.get(3) : null;
            this.strIngredient5 = ingredients.size() > 4 ? ingredients.get(4) : null;
            this.strIngredient6 = ingredients.size() > 5 ? ingredients.get(5) : null;
            this.strIngredient7 = ingredients.size() > 6 ? ingredients.get(6) : null;
            this.strIngredient8 = ingredients.size() > 7 ? ingredients.get(7) : null;
            this.strIngredient9 = ingredients.size() > 8 ? ingredients.get(8) : null;
            this.strIngredient10 = ingredients.size() > 9 ? ingredients.get(9) : null;
        }
    }
}

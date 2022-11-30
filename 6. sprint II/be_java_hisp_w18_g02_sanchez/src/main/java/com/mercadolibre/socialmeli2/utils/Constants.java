package com.mercadolibre.socialmeli2.utils;

public abstract class Constants {
    // PostDtoReq
    public static final String USER_ID_REQUIRED ="El id no puede estar vacío: user_id";
    public static final String USER_ID_POSITIVE="El id debe ser mayor a cero: user_id";

    public static final String DATE_REQUIRED="La fecha no puede estar vacía: date";

    public static final String CATEGORY_REQUIRED="El campo no puede estar vacío: category.";

    public static final String PRICE_REQUIRED="El campo no puede estar vacío: price";
    public static final String MAX_PRICE= "El precio máximo por producto es de 10.000.000: price";
    public static final String MIN_PRICE= "EL precio debe ser positivo: price";

    // ProductDto
    public static final String PRODUCT_ID_REQUIRED="El campo no puede estar vacío: product_id";
    public static final String PRODUCT_ID_POSITIVE="El campo debe ser mayor a cero: product_id";

    public static final String PRODUCT_NAME_REQUIRED="El campo no puede estar vacío: product_name";
    public static final String PRODUCT_NAME_MAX_LENGTH_40="La longitud no puede superar los 40 caracteres: product_name";
    public static final String PRODUCT_NAME_SPECIAL_CHARACTERS_NOT_ALLOWED="El campo no puede poseer caracteres especiales: product_name";

    public static final String TYPE_REQUIRED="El campo no puede estar vacío: type.";
    public static final String TYPE_MAX_LENGTH_15="La longitud no puede superar los 15 caracteres: type";
    public static final String TYPE_SPECIAL_CHARACTERS_NOT_ALLOWED= "El campo no puede poseer caracteres especiales: type";

    public static final String BRAND_REQUIRED="El campo no puede estar vacío: brand.";
    public static final String BRAND_MAX_LENGTH_15= "La longitud no puede superar los 15 caracteres: brand";
    public static final String BRAND_SPECIAL_CHARACTERS_NOT_ALLOWED= "El campo no puede poseer caracteres especiales: brand";

    public static final String COLOR_REQUIRED="El campo no puede estar vacío: color.";
    public static final String COLOR_MAX_LENGTH_15= "La longitud no puede superar los 15 caracteres: color";
    public static final String COLOR_SPECIAL_CHARACTERS_NOT_ALLOWED= "El campo no puede poseer caracteres especiales: color";

    public static final String MAX_LENGTH_80= "La longitud no puede superar los 80 caracteres: notes";
    public static final String NOTES_SPECIAL_CHARACTERS_NOT_ALLOWED= "El campo no puede poseer caracteres especiales: notes";
    public static final String ERROR_MSG_USER_NOT_FOUND= "No se pudo encontrar al usuario con id ";
    public static final String ERROR_MSG_USER_FOLLOW_SELF= "No es posible seguirse a si mismo.";
    public static final String SUCCESS_MSG_ADD_POST= "Post creado correctamente";

}

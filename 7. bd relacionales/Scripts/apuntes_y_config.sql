# APUNTES 



# To remove the clause ONLY_FULL_GROUP_BY: 
SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));



# HAVING
/*
Se usa para incluir condiciones con algunas funciones de SQL -> AFECTA a grupos obtenidos por el GROUP BY. 
WHERE -> Opera sobre registros individuales
HAVING -> lo hace sobre un grupo de registros 
*/


# ORDEN DE EJECUCIÓN
# WHERE > FUNCIONES DE AGREGACIÓN > HAVING


# TABLAS TEMPORALES -> Tabla de sesión

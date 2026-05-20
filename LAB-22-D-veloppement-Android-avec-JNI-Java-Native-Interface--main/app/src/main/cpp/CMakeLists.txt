
cmake_minimum_required(VERSION 3.22.1)

# Nom du projet
project("jnisemo")

# Ajout de la bibliothèque native (Assurez-vous que le nom du fichier .cpp est correct)
add_library(native-lib SHARED native-lib.cpp)

# Recherche de la bibliothèque de log Android
find_library(log-lib log)

# Liaison des bibliothèques
target_link_libraries(native-lib ${log-lib})
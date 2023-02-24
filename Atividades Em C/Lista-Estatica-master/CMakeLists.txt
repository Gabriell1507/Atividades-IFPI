cmake_minimum_required(VERSION 3.23)
project(ListaEstatica C)

set(CMAKE_C_STANDARD 99)

add_executable(ListaEstatica main.c lista.h lista.c)

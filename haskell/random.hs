
-- Raiz cuadrada
square(x) = x * x
main = print (square 42)

-- Contar elementos lista
contarElems :: [Int] -> Int
contarElems [] = 0
contarElems (x:xs) = 1 + contarElems xs
main = print (contarElems [1, 2, 3, 4, 5])

-- Eleva al cuadrado cada elemento de la lista
listaAlCuadrado :: [Int] -> [Int]
listaAlCuadrado [] = []
listaAlCuadrado [x] = [x * x]
listaAlCuadrado (x:xs) = (x * x) : (listaAlCuadrado xs)
main = print (listaAlCuadrado [1, 2, 3, 4, 5])

-- Contar pares de una lista
esPar :: Int -> Int
esPar x
    | even x = 1
    | otherwise = 0
    
contarPares :: [Int] -> Int
contarPares [] = 0
contarPares (x:xs) = (esPar x) + contarPares xs
main = print (contarPares [1, 2, 3, 4, 5, 6])

-- Contar pares de una lista (Recibiendo función por parámetro)
esPar :: Int -> Int
esPar x
    | even x = 1
    | otherwise = 0
    
contarPares :: (Int -> Int) -> [Int] -> Int
contarPares f [] = 0
contarPares f (x:xs) = (f x) + contarPares f xs
main = print (contarPares esPar [1, 2, 3, 4, 5, 6])

-- Sumar pares de una lista
sumar :: Int -> Int
sumar x = case (x `mod` 2) of
0 -> x
_ -> 0
contarPares :: [Int] -> Int
contarPares [] = 0
contarPares (x:xs) = (sumar x) + contarPares xs
main = print (contarPares [1, 2, 3, 4, 5, 6])

-- Sacar los 3 primeros de una lista
quitaTres :: [a] -> [a]
quitaTres (_:_:_:xs) = xs
quitaTres _ = []
main = print(quitaTres [1,2,3,4,5])

-- Encolar
queue :: a -> [a] -> [a]
queue x xs = xs++[x]

-- Decolar
dequeue :: [a] -> a
dequeue (x:xs) = x

-- Apilar
push :: a -> [a] -> [a]
push x xs = x:xs

-- Desapilar
pop :: [a] -> a
pop (x:xs) = x

-- Funciones parcialmente evaluadas
function x y = x + y
fun y = function 3 y
fun 2

applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)
main = print (applyTwice (*3) 2)

-- Parcial 3 TM - Ej 1
-- Descripción: Retornar ultimo de una lista, si está vacía, retornar 0
-- Estrategia voy cortando la lista con el operador ":" hasta que queda el último

ult :: [Int] -> Int
ult [] = 0
ult [x] = x
ult (_:xs) = ult xs

main = print(ult [1,1,5,7,0,4,2])

# Caesar Cipher

This program has two forms of encryption:

1. Using one key, where it shifts the alphabet by that key number.
2. Using two keys, where key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character.

There are two ways of decrypting Caesar Cipher:

1. Where you have an array of common words and you change the key incrementally, shifting the alphabet until it matches some of these words (also known as brute force).

2. Using the most common letter based on the spoken language. It's known that English texts have a lot of 'e's, so, you search in the encrypted text the most common letter and then you subtract its distance from letter 'e' to find out the shifting distance. One caveat about this method: it doesn't work with very small texts or phrase. It better use "brute force" for those cases. 

package org.example.dp.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Character {
    void draw(int x, int y);
}

// ConcreteFlyweight class
class CharacterImpl implements Character {
    private char character;

    public CharacterImpl(char character) {
        this.character = character;
    }

    @Override
    public void draw(int x, int y) {
        // Draw the character at the specified coordinates
    }
}

// FlyweightFactory class
class CharacterFactory {
    private Map<java.lang.Character, CharacterImpl> characters = new HashMap<>();

    public Character getCharacter(char character) {
        CharacterImpl characterImpl = characters.get(character);
        if (characterImpl == null) {
            characterImpl = new CharacterImpl(character);
            characters.put(character, characterImpl);
        }
        return characterImpl;
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        Character characterA = factory.getCharacter('A');
        Character characterB = factory.getCharacter('A');
        // ... use characterA and characterB
    }
}
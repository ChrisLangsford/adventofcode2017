package day4;

import org.junit.Assert;
import org.junit.Test;

public class AnagramCheckerTest {

    @Test
    public void anagramChecker(){
        PassPhraseChecker passPhraseChecker = new PassPhraseChecker();

        Assert.assertEquals(passPhraseChecker.anagramCheck("abcde","ecdab"), true);
        Assert.assertEquals(passPhraseChecker.anagramCheck("mama","aamm"), true);
        Assert.assertEquals(passPhraseChecker.anagramCheck("bob","dog"), false);
    }
}

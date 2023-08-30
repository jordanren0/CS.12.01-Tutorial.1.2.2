public class HiddenWord{
    String hiddenWord;

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getHiddenWord(){
        return hiddenWord.toUpperCase();
    }

    public String getHint(String guess){
        if(!isCapital(guess)){
            throw new IllegalArgumentException("Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }
        if(guess.length() != hiddenWord.length()){
            throw new IllegalArgumentException("Your guess ( " + guess + " ) has " + guess.length() +  " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!");
        }
        String str = "";
        String hidden = getHiddenWord();
        for(int i = 0; i < guess.length(); i++){
            if(guess.charAt(i) == hidden.charAt(i)){
                str = str + guess.charAt(i);
            }
            else if(hidden.indexOf(guess.charAt(i)) != -1){
                str = str + "+";
            }
            else{
                str = str + "*";
            }
        }
        return str;
    }

    public boolean isCapital(String guess){
        char[] guessArr = guess.toCharArray();
        boolean isUpperCase = true;
        for(int i = 0; i < guess.length(); i++){
            if(!Character.isUpperCase(guessArr[i])){
                if(Character.isAlphabetic(guessArr[i]))
                    isUpperCase = false;
                break;
            }
        }
        return isUpperCase;
    }
}

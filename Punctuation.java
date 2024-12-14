// Rajvansh Gupta
// 12/11/2024
// Period 5

/*
Punctuation.java

Description:
This program processes a given text to extract and print all the words containing punctuation. It is designed to illustrate text parsing, handling punctuation, and structured programming using Java methods.

Methods:
1. **main**: This is the entry point of the program. It initializes the text to be analyzed, creates an instance of the Punctuation class, and calls the primary method `searchIt` to begin processing.

2. **searchIt**: This method orchestrates the text processing workflow. It calls `getPunctuationWords` to extract words containing punctuation and then sends the resulting list to `printWords` for output.

3. **getPunctuationWords**: This is the core method that processes the text to extract words containing punctuation. It iterates through the text, identifies individual words, and checks them for punctuation using `checkForPunctuation`.

4. **checkForPunctuation**: This helper method checks if a given word contains any punctuation. It compares each character in the word against a predefined set of punctuation characters.

5. **printWords**: This method takes the processed text and prints the list of words containing punctuation.
*/

public class Punctuation {
    public static void main(String[] args) {
        // Define the text to analyze
String text = "Blood, Sweat, and Tears by Winston Churchill " +
"May 13, 1940" +
"Mr. Speaker:" +
"On Friday evening last I received His Majesty’s commission to form a new " +
"Administration. It was the evident wish and will of Parliament and the " +
"nation that this should be conceived on the broadest possible basis and that it" +
" should include all parties, both those who supported the late Government and " +
" also the parties of the Opposition." +
"I have completed the most important part of this task. A War Cabinet has been " +
"formed of five Members, representing, with the Liberal Opposition, the unity of " +
"the nation. The three party Leaders erhave agreed to serve, either in the War" +
" Cabinet or in high executive office. The three Fighting Services have " +
" been filled. It was necessary that this should be done in one single day, " +
"on account of the extreme urgency and rigour of events. A number of other " +
"key positions were filled yesterday, and I am submitting a further list to " +
"His Majesty tonight. I hope to complete the appointment of the principal " +
"Ministers during tomorrow. The appointment of the other Ministers usually " +
" takes a little longer, but I trust that, when Parliament meets again, " +
"this part of my task will be completed, and that the " +
"Administration will be complete in all respects." + "Sir, I considered it " +
"in the public interest to suggest that the House should be summoned to " +
" meet today. Mr. Speaker agreed and took the necessary steps, in " +
"accordance with the powers conferred upon him by the Resolution of the House. At the " +
"end of the proceedings today, the Adjournment of the House will be proposed until " +
"Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The " +
"business to be considered during that week will be notified to Members at the earliest " +
"opportunity. I now invite the House, by the Resolution which stands in my name, to " +
"record its approval of the steps taken and to declare its confidence in the new " +
"Government." +
"Sir, to form an Administration of this scale and complexity is a serious " +
"undertaking in itself, but it must be remembered that we are in the preliminary stage of " +
"one of the greatest battles in history, that we are in action at many points in Norway and " +
"in Holland, that we have to be prepared in the Mediterranean, that the air battle is " +
"continuous and that many preparations have to be made here at home. In this crisis I " +
"hope I may be pardoned if I do not address the House at any length today. I hope that any of my friends and colleagues, or former colleagues, who are affected by the political " +
"reconstruction, will make all allowances for any lack of ceremony with which it has been " +
"necessary to act. I would say to the House, as I said to those who’ve joined this " +
"government: \"I have nothing to offer but blood, toil, tears and sweat.\"" +
"We have before us an ordeal of the most grievous kind. We have before " +
"us many, many long months of struggle and of suffering. You ask, what is our policy? I " +
"will say: It is to wage war, by sea, land and air, with all our might and with all the " +
"strength that God can give us; to wage war against a monstrous tyranny, never " +
"surpassed in the dark and lamentable catalogue of human crime. That is our policy. You " +
"ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in " +
"spite of all terror, victory, however long and hard the road may be; for without victory, " +
"there is no survival. Let that be realised; no survival for the British Empire, no survival " +
"for all that the British Empire has stood for, no survival for the urge and impulse of the " +
"ages, that mankind will move forward towards its goal. " +
"But I take up my task with buoyancy and hope. I feel sure that our cause " +
"will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, " +
"and I say, \"Come then, let us go forward together with our united strength.\"";
        // Create an instance of the Punctuation class
        Punctuation punct = new Punctuation();

        // Call the searchIt method to process the text
        punct.searchIt(text);
    }

    public void searchIt(String text) {
        // Prints blank lines for formatting
        System.out.println("\n\n\n");

        // Calls getPunctuationWords to extract words with punctuation
        String punctuationWords = getPunctuationWords(text);

        // Calls printWords to display the resulting words
        printWords(punctuationWords);

        // Prints blank lines for formatting
        System.out.println("\n\n\n");
    }

    public String getPunctuationWords(String text) {
        // Initialize a new word string and result accumulator
        String newWord = "";
        String result = "";
        int begin = 0;
        int endIndex = 0;

        // Loop through each character in the text
        for (int i = 0; i < text.length(); i++) {
            // Check if the current character is a space to mark the end of a word
            if (text.charAt(i) == ' ') {
                endIndex = i;

                // Extract the word between 'begin' and 'endIndex'
                newWord = text.substring(begin, endIndex);

                // Check if the word contains punctuation
                if (checkForPunctuation(newWord)) {
                    // Concatenate the word with punctuation to the result
                    if (result.isEmpty()) {
                        result += newWord;
                    } else {
                        result = result + " " + newWord;
                    }
                }

                // Move to the next word
                begin = endIndex + 1;
            }

            // Check if it's the last character of the text
            if (i == text.length() - 1) {
                endIndex = i + 1;

                // Extract the final word
                newWord = text.substring(begin, endIndex);

                // Check if the word contains punctuation
                if (checkForPunctuation(newWord)) {
                    if (result.isEmpty()) {
                        result += newWord;
                    } else {
                        result = result + " " + newWord;
                    }
                }
            }
        }

        // Return all words with punctuation
        return result;
    }

    public boolean checkForPunctuation(String word) {
        // Initialize the flag for punctuation detection
        boolean returner = false;

        // Define the set of punctuation characters
        String punctuation = ",.?/:;'\")(";

        // Check each character in the word for punctuation
        for (int z = 0; z < word.length(); z++) {
            for (int i = 0; i < punctuation.length(); i++) {
                if (word.charAt(z) == punctuation.charAt(i)) {
                    returner = true; // Mark as containing punctuation
                }
            }
        }

        // Return true if punctuation is found
        return returner;
    }

    public void printWords(String text) {
        // Print the words with punctuation
        System.out.print(text);
    }
}


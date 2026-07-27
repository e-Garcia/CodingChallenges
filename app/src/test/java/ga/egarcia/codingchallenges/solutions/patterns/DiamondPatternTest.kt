package ga.egarcia.codingchallenges.solutions.patterns

import org.junit.Assert.*
import org.junit.Test

class DiamondPatternTest {
    @Test
    fun printDiamondPattern() {
        val expectedOutput = """
            *    
           ***   
          *****  
         ******* 
          *****  
           ***   
            *    
        """.trimIndent()

        val result = printDiamondPattern(7)

        assertEquals(expectedOutput, result.trim())
    }

    /**
     * Example output for n = 3:
     * middle = 1
     *  *   -> 1( ) + 1(*)
     * ***  -> 0( ) + 3(*)
     *  *   -> 1( ) + 1(*)
     */


    /**
     * Example output for n = 8:
     * middle = 4
     *    *      -> 3( ) + 1 (*)
     *   ***     -> 2( ) + 3 (*)
     *  *****    -> 1( ) + 5 (*)
     * *******   -> 0( ) + 7 (*)
     * *******   -> 0( ) + 7 (*)
     *  *****    -> 1( ) + 5 (*)
     *   ***     -> 2( ) + 3 (*)
     *    *      -> 3( ) + 1 (*)
     */

}
class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    //Hello World => 5#Hello5#World
    encode(strs) {
        let encodeStr="";
        for(let word of strs){
            const length = word.length;
            encodeStr+=length;
            encodeStr+="#";
            encodeStr+=word;
        }

        return encodeStr;
    }

    /**
     * @param {string} str
     * @returns {string[]}
     * 5#Hello5#World
     */
    decode(str) {
        let left =0;
        const result=[];
        while(left < str.length){
            let right = left;

            while(str[right] != '#'){
                right++;
            }
            const length=Number(str.substring(left, right));
           
            const startOfWord = right + 1;
            const endOfWord = startOfWord + length;
            
            const word = str.substring(startOfWord, endOfWord);
            result.push(word);
            left = endOfWord;

        }


        return result;
    }
}

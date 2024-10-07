class Solution:
    def minLength(self, s: str) -> int:
        char_list = list(s)
        write_ptr = 0

        # Iterate over each character in the string
        for read_ptr in range(len(s)):
            # Write the current character to the current write position
            char_list[write_ptr] = char_list[read_ptr]

            # Check if we have a valid pattern to remove
            if (
                write_ptr > 0
                and char_list[write_ptr - 1] in "AC"
                and ord(char_list[write_ptr])
                == ord(char_list[write_ptr - 1]) + 1
            ):
                write_ptr -= 1
            else:
                write_ptr += 1  # No match, so move the write pointer forward

        # The write_ptr now represents the length of the remaining string
        return write_ptr
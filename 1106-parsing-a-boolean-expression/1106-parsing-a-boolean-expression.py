class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        index = [
            0
        ]  # using a list because python variables are pass by object reference
        return self._evaluate(expression, index)

    # Recursively parse and evaluate the boolean expression
    def _evaluate(self, expr: str, index: list) -> bool:
        curr_char = expr[index[0]]
        index[0] += 1

        # Base cases: true ('t') or false ('f')
        if curr_char == "t":
            return True
        if curr_char == "f":
            return False

        # Handle NOT operation '!(...)'
        if curr_char == "!":
            index[0] += 1  # skip '('
            result = not self._evaluate(expr, index)
            index[0] += 1  # skip ')'
            return result

        # Handle AND '&(...)' and OR '|(...)'
        values = []
        index[0] += 1  # skip '('
        while expr[index[0]] != ")":
            if expr[index[0]] != ",":
                values.append(
                    self._evaluate(expr, index)
                )  # collect results of subexpressions
            else:
                index[0] += 1  # skip commas
        index[0] += 1  # skip ')'

        # Manual AND operation: returns false if any value is false
        if curr_char == "&":
            return all(values)

        # Manual OR operation: returns true if any value is true
        if curr_char == "|":
            return any(values)

        return False  # this point should never be reached
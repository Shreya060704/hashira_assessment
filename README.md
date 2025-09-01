# Polynomial Solver

## Problem Statement
You are given the roots of a polynomial in JSON format.  
Each root is provided in a specific base along with its value.  

Your task is to:
1. Convert each root from the given base to decimal.
2. Construct the polynomial:
   \[
   P(x) = (x - r_1)(x - r_2)...(x - r_n)
   \]
3. Output the coefficients of the polynomial in JSON format.

---

## Sample Test Case 1

### Input
```json
{
  "keys": [
    {"base": "10", "value": "4"},
    {"base": "2", "value": "111"},
    {"base": "13", "value": "12"},
    {"base": "6", "value": "213"}
  ],
  "n": 4,
  "k": 3
}

Output

{
  "coefficients": [
    "1",
    "-107",
    "2299",
    "-16053",
    "34020"
  ]
}

Input 2

{
  "keys": [
    {"base": "15", "value": "aed7015a34dd85"},
    {"base": "15", "value": "6caeb66931c227c"},
    {"base": "16", "value": "e1b596523d881f"},
    {"base": "5",  "value": "8"},
    {"base": "6",  "value": "13444211404455345511"},
    {"base": "7",  "value": "2121212011200211120021001020200"}
  ],
  "n": 10,
  "k": 7
}

Output(truncated example)

{
  "coefficients": [
    "1",
    "...",
    "...",
    "..."
  ]
}


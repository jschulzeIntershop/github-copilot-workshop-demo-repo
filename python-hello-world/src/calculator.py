# simple calculator which offers addition, substraction, multiplication and division
def add(x, y):
    """Add two numbers."""
    return x + y

# subtract function which takes two numbers and returns the difference
def subtract(x, y):
    """Subtract two numbers."""
    return x - y

#multiply function which takes two numbers and returns the product
def multiply(x, y):
    """Multiply two numbers."""
    return x * y

#divide function which takes two numbers and returns the quotient
def divide(x, y):
    """Divide two numbers."""
    if y == 0:
        raise ValueError("Cannot divide by zero.")
    return x / y

#modulus function which takes two numbers and returns the remainder
def modulus(x, y):
    """Modulus of two numbers."""
    return x % y

#exponent function which takes two numbers and returns the exponent
def exponent(x, y):
    """Exponent of two numbers."""
    return x ** y

#floor division function which takes two numbers and returns the floor division
def floor_division(x, y):
    """Floor division of two numbers."""
    return x // y

#square root function which takes one number and returns the square root
def square_root(x):
    """Square root of a number."""
    if x < 0:
        raise ValueError("Cannot take square root of negative number.")
    return x ** 0.5

# main function which takes two numbers and returns the product
def main():
    """Main method to use the multiply function with user inputs."""
    try:
        x = float(input("Enter the first number: "))
        y = float(input("Enter the second number: "))
        result = multiply(x, y)
        print(f"The result of multiplying {x} and {y} is {result}.")
    except ValueError:
        print("Invalid input. Please enter numeric values.")

if __name__ == "__main__":
    main()



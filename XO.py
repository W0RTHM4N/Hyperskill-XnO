field = [[" ", " ", " "],
         [" ", " ", " "],
         [" ", " ", " "]]
digits = list("0123456789")
grid_digits = list("123")
turn = 1
triple = None

while True:

    print("---------")
    print("|", field[0][0], field[0][1], field[0][2], "|")
    print("|", field[1][0], field[1][1], field[1][2], "|")
    print("|", field[2][0], field[2][1], field[2][2], "|")
    print("---------")

    if turn > 5:
        for i in range(0, 3):
            if field[i][0] == field[i][1] and field[i][1] == field[i][2]:
                triple = field[i][0]
            if field[0][i] == field[1][i] and field[1][i] == field[2][i]:
                triple = field[0][i]

        if field[0][0] == field[1][1] and field[1][1] == field[2][2] or \
                field[2][0] == field[1][1] and field[1][1] == field[0][2]:
            triple = field[1][1]

        if triple is not None and triple != " ":
            print(triple, "wins")
            break
        elif turn > 9:
            print("Draw")
            break

    coordinates = input("Enter the coordinates: ").split(" ", 2)
    row = None
    column = None

    if len(coordinates) < 2 or coordinates[0] not in digits or coordinates[1] not in digits:
        print("You should enter numbers!")
    elif coordinates[0] not in grid_digits or coordinates[1] not in grid_digits:
        print("Coordinates should be from 1 to 3!")
    else:
        row = abs(int(coordinates[1]) - 3)
        column = int(coordinates[0]) - 1
        if field[row][column] != " ":
            print("This cell is occupied! Choose another one!")
        else:
            field[row][column] = "X" if turn % 2 else "O"
            turn += 1
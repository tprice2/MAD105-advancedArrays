/*
Pseudocode
Variables: Inventory, qty, combArry, itemSearch, foundItemNum, etc.

Process:
First, initialize an array of item names and an array of quantities
I then add these two arrays into a two dimensional array called combArray.
The user is then asked to enter the string of the item they'd like to look up, which is stored in the variable itemSearch.
The combArray qty row is looped through, and if the value the user entered matches any of the values in the inventory array, the index is stored in the foundItemNum variable.
If the foundItemNum has a value that isn't -1 (the value it was initialized as), then the item the user searched for exists.
The name of the item and it's qty are printed, and then the user is asked how they'd like to alter the quantity.
If the change is greater than zero, then the new quantity is added to the existing one, and the final item total is displayed.
If the change is less than zero, the user is warned that this is an error.
 */
fun main(){
    val inventory = arrayOf("Stick", "Skates", "Helmet", "Gloves", "Jersey")
    val qty = arrayOf("3", "2", "7", "1", "3")

    var combArray = arrayOf<Array<String>>()

    combArray += inventory
    combArray += qty

    val numRows = combArray[0].size - 1

    println("Please enter the item you're looking for:")
    val itemSearch = readLine()!!
    var foundItemNum = -1

    for (i in 0..numRows)
    {
        val actualInventory = combArray[0][i]

        if (actualInventory == itemSearch) {
            foundItemNum = i
        }
    }
    if (foundItemNum != -1)
    {
        println("Item found: " + combArray[0][foundItemNum] + " with quantity " + combArray[1][foundItemNum])
        println("Please enter the change in inventory:\n")
        val inventoryChange = readLine()!!.toInt()


        if(((combArray[1][foundItemNum]).toInt() + inventoryChange) > 0)
        {
            println("Item: " + combArray[0][foundItemNum])
            println("Old quantity: " + combArray[1][foundItemNum])
            combArray[1][foundItemNum] = ((combArray[1][foundItemNum]).toInt() + inventoryChange).toString()
            println("Change: $inventoryChange")
            println("New quantity: " + combArray[1][foundItemNum])
        }
        else if(((combArray[1][foundItemNum]).toInt() + inventoryChange) == 0)
        {
            println("This has dropped the quantity to zero.")
            println("Item: " + combArray[0][foundItemNum])
            println("Old quantity: " + combArray[1][foundItemNum])
            combArray[1][foundItemNum] = ((combArray[1][foundItemNum]).toInt() + inventoryChange).toString()
            println("Change: $inventoryChange")
            println("New quantity: " + combArray[1][foundItemNum])
        }
        else{
            println("Error, the quantity change greater than the available inventory.")
            println("Item: " + combArray[0][foundItemNum])
            println("Old quantity: " + combArray[1][foundItemNum])
            println("Requested change: $inventoryChange | Actual change: -" + combArray[1][foundItemNum])
            combArray[1][foundItemNum] = "0"
            println("New quantity: " + combArray[1][foundItemNum])
        }
    }
    else
    {
        println("This item was not found")
    }


}
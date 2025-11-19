#! usr/bin/bash

set -e 

# print_java_template: 
#   Prints template code to the generated Java file
# Arguments:
#   $1: The name of the playground environment/test (string)
#   $2: The path to the generated Java file (string)
# Returns:
#   None 
function print_java_template() {
    echo -e "package $1;\n" >> "$2"
    echo -e "public class $1 {" >> "$2"
    echo -e "\tpublic static void main(String[] args) {" >> "$2"
    echo -e "\t\tSystem.out.println(\"Hello world from \'$2\'!\");" >> "$2"
    echo -e "\t}" >> "$2"
    echo -e "}" >> "$2"
}

# print_README_template: 
#   Prints a template to the generated README markdown file 
# Arguments:
#   $1: The name of the playground environment/test (string)
#   $2: The path to the generated README markdown file (string)
#   $3: The path to the generated Java file (string)
# Returns:
#   None 
function print_README_template() {
    echo "# $1" >> "$2"
    echo -e "\n\n" >> "$2"
    echo "\`\`\`bash" >> "$2"
    echo "java $3" >> "$2"
    echo "\`\`\`" >> "$2"
}

# Get CLI argument for the playground name and define file paths 
PLAYGROUND_NAME="$1"
JAVA_FILE_PATH="$PLAYGROUND_NAME"/"$PLAYGROUND_NAME.java"
README_FILE_PATH="$PLAYGROUND_NAME"/"$PLAYGROUND_NAME.md"

# Create the playground dir and generate the Java & README files 
mkdir "$PLAYGROUND_NAME"
touch "$JAVA_FILE_PATH"
touch "$README_FILE_PATH"

# Print templates to the respective files 
print_java_template "$PLAYGROUND_NAME" "$JAVA_FILE_PATH"
print_README_template "$PLAYGROUND_NAME" "$README_FILE_PATH" "$JAVA_FILE_PATH"

# Test template code 
java "$JAVA_FILE_PATH"
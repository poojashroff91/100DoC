package builder;

import com.sun.tools.javac.jvm.Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Field {
    public String name, type;
    private final String newLine = System.lineSeparator();
    private final int indentSize = 2;

    public Field(String name, String type){
        this.name = name;
        this.type = type;

    }

    private String toStringImpl(){

        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indentSize," "));
        sb.append(String.format("%spublic %s %s;%s", i, type, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl();
    }
}

public class CodeBuilder
{
    private String className;
    private List<Field> fields;
    private final String newLine = System.lineSeparator();



    public CodeBuilder(String className)
    {
        // todo
        this.className = className;
        this.fields = new ArrayList<>();
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        this.fields.add(new Field(name, type));
        return this;

    }

    public String toStringImpl(){

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("public class %s%s{%s", className, newLine, newLine));
        for (Field field: fields){
            sb.append(field.toString());
        }
        sb.append("}");
        return sb.toString();

    }

    @Override
    public String toString()
    {
        // todo
        return toStringImpl();
    }
}

class CodeBuilderDemo {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
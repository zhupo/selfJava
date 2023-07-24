module selfJava {
    //访问权限 exports ObjectOrientedProgramming;

    requires java.base;//可以不写，任何模块都自动引入java.base
    requires java.xml;
    requires java.logging;
}
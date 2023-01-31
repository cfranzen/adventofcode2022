package de.cfranzen.adventofcode.day7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    private final List<String> lines = List.of(
            "$ cd /",
            "$ ls",
            "dir a",
            "14848514 b.txt",
            "8504156 c.dat",
            "dir d",
            "$ cd a",
            "$ ls",
            "dir e",
            "29116 f",
            "2557 g",
            "62596 h.lst",
            "$ cd e",
            "$ ls",
            "584 i",
            "$ cd ..",
            "$ cd ..",
            "$ cd d",
            "$ ls",
            "4060174 j",
            "8033020 d.log",
            "5626152 d.ext",
            "7214296 k");

    @Test
    void testParsing() {
        final Directory root = new InputParser().parseFilesystem(lines);

        assertThat(root).isEqualTo(Directory.newRoot()
                .mkdir("a")
                .mkdir("d")
                .createFile("b.txt", 14848514)
                .createFile("c.dat", 8504156)
                .getDir("a")
                .mkdir("e")
                .createFile("f", 29116)
                .createFile("g", 2557)
                .createFile("h.lst", 62596)
                .getDir("e")
                .createFile("i", 584)
                .getParent()
                .getParent()
                .getDir("d")
                .createFile("j", 4060174)
                .createFile("d.log", 8033020)
                .createFile("d.ext", 5626152)
                .createFile("k", 7214296)
                .getParent());
    }
}
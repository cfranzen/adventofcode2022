package de.cfranzen.adventofcode.day7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FilesystemTest {

    private final Directory root = Directory.newRoot()
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
            .getParent();

    @Test
    void testPathCalculation() {
        assertThat(root
                .getDir("a")
                .getDir("e").getPath()).isEqualTo("/a/e/");

        assertThat(root
                .getDir("a")
                .getDir("e")
                .getFile("i").getPath()).isEqualTo("/a/e/i");

        assertThat(root
                .getDir("d").getPath()).isEqualTo("/d/");

        assertThat(root
                .getDir("d")
                .getFile("d.ext").getPath()).isEqualTo("/d/d.ext");

        assertThat(root.getPath()).isEqualTo("/");

        assertThat(root.getFile("c.dat").getPath()).isEqualTo("/c.dat");
    }

    @Test
    void testSizeCalculation() {
        assertThat(root
                .getDir("a")
                .getDir("e").getSize())
                .isEqualTo(584);

        assertThat(root.getDir("a").getSize())
                .isEqualTo(94853);

        assertThat(root.getDir("d").getSize())
                .isEqualTo(24933642);

        assertThat(root.getSize()).isEqualTo(48381165);

        assertThat(root
                .getDir("d")
                .getFile("d.ext").getSize())
                .isEqualTo(5626152);

        assertThat(root.getFile("c.dat").getSize()).isEqualTo(8504156);
    }
}
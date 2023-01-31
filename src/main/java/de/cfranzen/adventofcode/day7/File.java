package de.cfranzen.adventofcode.day7;

import java.util.Objects;

public class File {

    private final Directory parent;

    private final String name;

    private final long size;

    File(Directory parent, String name, long size) {
        this.parent = parent;
        this.name = name;
        this.size = size;
    }

    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return parent.getPath() + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size && name.equals(file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "File " + getPath();
    }
}

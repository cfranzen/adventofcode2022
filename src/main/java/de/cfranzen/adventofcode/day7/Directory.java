package de.cfranzen.adventofcode.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Directory {

    private final Directory parent;

    private final String name;

    private final Map<String, Directory> subdirs = new HashMap<>();
    private final Map<String, File> files = new HashMap<>();

    private Directory(Directory parent, String name) {
        this.parent = (parent == null) ? this : parent;
        this.name = name;
    }

    public static Directory newRoot() {
        return new Directory(null, "root");
    }

    public String getPath() {
        if (parent == this) {
            return "/";
        } else {
            return parent.getPath() + name + "/";
        }
    }

    public long getSize() {
        long size = 0;
        for (var subdir : subdirs.values()) {
            size += subdir.getSize();
        }
        for (var file : files.values()) {
            size += file.getSize();
        }
        return size;
    }

    public Directory mkdir(String name) {
        final Directory previousDir = subdirs.put(name, new Directory(this, name));
        if (previousDir != null) {
            throw new IllegalArgumentException("Subdirectory with name " + name + " already exists");
        }
        return this;
    }

    public Directory createFile(String name, long size) {
        final File previousFile = files.put(name, new File(this, name, size));
        if (previousFile != null) {
            throw new IllegalArgumentException("File with name " + name + " already exists");
        }
        return this;
    }

    public Directory getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public Directory getDir(String name) {
        final Directory subdir = subdirs.get(name);
        if (subdir == null) {
            throw new IllegalArgumentException("Directory with name " + name + " does not exists");
        }
        return subdir;
    }

    public File getFile(String name) {
        final File file = files.get(name);
        if (file == null) {
            throw new IllegalArgumentException("File with name " + name + " does not exists");
        }
        return file;
    }

    public List<Directory> getSubDirs() {
        return List.copyOf(subdirs.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return name.equals(directory.name) && subdirs.equals(directory.subdirs) && files.equals(directory.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subdirs, files);
    }

    @Override
    public String toString() {
        return "Directory " + getPath();
    }
}

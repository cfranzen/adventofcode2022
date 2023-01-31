package de.cfranzen.adventofcode.day6;

public class DataStreamBuffer {

    private final String data;

    public DataStreamBuffer(String data) {
        this.data = data;
    }

    public int findFirstMarker(int markerLength) {
        final int length = data.length() - markerLength;
        int index = 0;
        for (; index < length; index++) {
            final int endIndex = index + markerLength;
            if (!hasDuplicateChars(index, endIndex)) {
                return endIndex;
            }
        }
        return -1;
    }

    private boolean hasDuplicateChars(int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex - 1; i++) {
            for (int j = i + 1; j < endIndex; j++) {
                if (data.charAt(i) == data.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}

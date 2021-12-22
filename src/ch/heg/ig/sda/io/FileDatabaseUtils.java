package ch.heg.ig.sda.io;

public class FileDatabaseUtils {

    public static final int NOT_FOUND_INDEX = -1;

    /**
     * Find the column index in a header corresponding to a column name.
     * @param header File header
     * @param columnName Name of the column in the header
     * @return Corresponding column index or -1
     */
    public static int findColumnIndex(String[] header, String columnName){

        if(header == null)
            throw new IllegalArgumentException("Header is null");

        boolean found;
        int columnIndex = 0;
        String headerColumnName;

        do {
            headerColumnName = header[columnIndex].trim().toLowerCase();
            found = headerColumnName.equals(columnName.trim().toLowerCase());
            if(!found)
                columnIndex++;

        } while ( (!found) && (columnIndex < header.length) );

        return found ? columnIndex : NOT_FOUND_INDEX;
    }

}

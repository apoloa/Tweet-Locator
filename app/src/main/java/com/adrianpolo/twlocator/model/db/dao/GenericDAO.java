package com.adrianpolo.twlocator.model.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.adrianpolo.twlocator.model.db.DBHelper;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @param <T> Represents a model object
 */
public abstract class GenericDAO <T extends Persistable> {
    private static final long INVALID_ID_DELETE_ALL_RECORDS = 0;

    protected DBHelper db;

    public GenericDAO() { db = DBHelper.getInstance(); }

    // Abstract Classes

    protected abstract String getTableName();
    protected abstract String getIdRepresentativeValue();
    protected abstract ContentValues getContentValues(T Object);
    protected abstract String[] getAllColums();
    protected abstract @NonNull T elementFromCursor(final @NonNull Cursor c);

    public long insert(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Passing NULL object");
        }

        // insert

        long id = db.getWritableDatabase().insert(getTableName(), null, this.getContentValues(object));
        object.setId(id);
        db.close();

        return id;
    }

    public int update(long id, T object) {
        if (object == null) {
            throw new IllegalArgumentException("Passing NULL object");
        }
        if (id < 1) {
            throw new IllegalArgumentException("Passing id invalid");
        }

        int numberOfRowsUpdated = db.getWritableDatabase().update(getTableName(),
                this.getContentValues(object),
                getIdRepresentativeValue() + "=?", new String[]{"" + id});

        db.close();
        return numberOfRowsUpdated;
    }

    public void delete(long id) {
        if (id == INVALID_ID_DELETE_ALL_RECORDS) {
            db.getWritableDatabase().delete(getTableName(),  null, null);
        } else {
            db.getWritableDatabase().delete(getTableName(), getIdRepresentativeValue() + " = " + id, null);
        }
        db.close();
    }

    public void deleteAll() {
        delete(INVALID_ID_DELETE_ALL_RECORDS);
    }

    public Cursor queryCursor() {
        // select

        Cursor c = db.getReadableDatabase().query(getTableName(),
                getAllColums(),
                null, // selection
                null, //  selectionArgs
                null, // groupBy
                null, // having
                getIdRepresentativeValue()  // orderBy
        );

        return c;
    }

    public List<T> query() {
        List<T> listObjects = new LinkedList<>();

        Cursor cursor = queryCursor();
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                T object = elementFromCursor(cursor);
                listObjects.add(object);
            } while (cursor.moveToNext());
        }
        return listObjects;
    }

    public @Nullable T query(long id) {
        T object = null;

        String where = getIdRepresentativeValue() + "=" + id;
        Cursor c = db.getReadableDatabase().query(getTableName(), getAllColums(), where, null, null, null, null);
        if (c != null) {
            if (c.getCount() > 0) {
                c.moveToFirst();
                object = elementFromCursor(c);
            }
            c.close();
        }
        db.close();
        return object;
    }
}

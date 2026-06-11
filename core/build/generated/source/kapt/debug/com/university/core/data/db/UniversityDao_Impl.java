package com.university.core.data.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UniversityDao_Impl implements UniversityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UniversityEntity> __insertionAdapterOfUniversityEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public UniversityDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUniversityEntity = new EntityInsertionAdapter<UniversityEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `universities` (`name`,`country`,`alphaTwoCode`,`stateProvince`,`domains`,`webPages`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UniversityEntity entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCountry());
        }
        if (entity.getAlphaTwoCode() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAlphaTwoCode());
        }
        if (entity.getStateProvince() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStateProvince());
        }
        if (entity.getDomains() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDomains());
        }
        if (entity.getWebPages() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getWebPages());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM universities";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<UniversityEntity> universities,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUniversityEntity.insert(universities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllUniversities(final Continuation<? super List<UniversityEntity>> $completion) {
    final String _sql = "SELECT * FROM universities ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<UniversityEntity>>() {
      @Override
      @NonNull
      public List<UniversityEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfAlphaTwoCode = CursorUtil.getColumnIndexOrThrow(_cursor, "alphaTwoCode");
          final int _cursorIndexOfStateProvince = CursorUtil.getColumnIndexOrThrow(_cursor, "stateProvince");
          final int _cursorIndexOfDomains = CursorUtil.getColumnIndexOrThrow(_cursor, "domains");
          final int _cursorIndexOfWebPages = CursorUtil.getColumnIndexOrThrow(_cursor, "webPages");
          final List<UniversityEntity> _result = new ArrayList<UniversityEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final UniversityEntity _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpAlphaTwoCode;
            if (_cursor.isNull(_cursorIndexOfAlphaTwoCode)) {
              _tmpAlphaTwoCode = null;
            } else {
              _tmpAlphaTwoCode = _cursor.getString(_cursorIndexOfAlphaTwoCode);
            }
            final String _tmpStateProvince;
            if (_cursor.isNull(_cursorIndexOfStateProvince)) {
              _tmpStateProvince = null;
            } else {
              _tmpStateProvince = _cursor.getString(_cursorIndexOfStateProvince);
            }
            final String _tmpDomains;
            if (_cursor.isNull(_cursorIndexOfDomains)) {
              _tmpDomains = null;
            } else {
              _tmpDomains = _cursor.getString(_cursorIndexOfDomains);
            }
            final String _tmpWebPages;
            if (_cursor.isNull(_cursorIndexOfWebPages)) {
              _tmpWebPages = null;
            } else {
              _tmpWebPages = _cursor.getString(_cursorIndexOfWebPages);
            }
            _item = new UniversityEntity(_tmpName,_tmpCountry,_tmpAlphaTwoCode,_tmpStateProvince,_tmpDomains,_tmpWebPages);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

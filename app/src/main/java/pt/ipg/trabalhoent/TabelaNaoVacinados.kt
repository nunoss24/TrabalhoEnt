package pt.ipg.trabalhoent

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaNaoVacinados(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria(){
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME + " TEXT NOT NULL, " +
                CAMPO_DATA_NASCIMENTO+ " DATE NOT NULL, " +
                CAMPO_NIF+ "  INTEGER NOT NULL, " +
                CAMPO_DATA_VACINA1+ " DATE NOT NULL, " +
                CAMPO_ID_VACINA1 + " DATE NOT NULL, " +
                CAMPO_ID_VACINADOS + " INTEGER, " +
                " FOREIGN KEY ("+ CAMPO_ID_VACINA1 +") " +
                " REFERENCES " + TabelaVacina1.NOME_TABELA +
                " FOREIGN KEY ("+ CAMPO_ID_VACINADOS +") " +
                " REFERENCES " + TabelaVacinados.NOME_TABELA +
                ")"
        )

    }

    fun insert(values: ContentValues): Long {
        return db.insert(NOME_TABELA,null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(NOME_TABELA,whereClause, whereArgs)
    }

    fun query(
            columns: Array<String>,
            selection: String,
            selectionArgs: Array<String>,
            groupBy: String,
            having: String,
            orderBy: String
    ): Cursor? {
        return db.query(NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object{
        const val NOME_TABELA = "NaoVacinados"
        const val CAMPO_NOME = "nome"
        const val CAMPO_DATA_NASCIMENTO = "data de nascimento"
        const val CAMPO_NIF = "nif"
        const val CAMPO_DATA_VACINA1 = "data_marcacao"
        const val CAMPO_ID_VACINA1 = "id_vacina1"
        const val CAMPO_ID_VACINADOS = "id_vacinados"
    }

}

package br.edu.up.themuseum.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.up.themuseum.data.Dao.PedidosDao
import br.edu.up.themuseum.data.Models.Pedidos

//cardapio:: class
@Database(entities = [Pedidos::class], version = 1)
abstract class PedidosDataBase: RoomDatabase(){
    abstract fun PedidosDao(): PedidosDao
}


fun abrirBancoDeDados(context: Context): PedidosDataBase{
    return Room.databaseBuilder(
        context.applicationContext,
        PedidosDataBase::class.java, "pedidos.db"
    ).build()
}
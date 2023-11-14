package com.example.paymentintegration

import ParseItem
import ParseModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import com.example.paymentintegration.ModelClass.MyData
import com.example.paymentintegration.ModelClass.Order
import com.example.paymentintegration.ModelClass.OrderDTO
import com.example.paymentintegration.ModelClass.OrderGoodsDetail
import com.example.paymentintegration.ModelClass.OrderModel
import com.example.paymentintegration.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()

        val json ="""
        [ { "id": "0001", "type": "donut", "name": "Cake", "ppu": 0.55, "batters": { "batter": [ { "id": "1001", "type": "Regular" }, { "id": "1002", "type": "Chocolate" }, { "id": "1003", "type": "Blueberry" }, { "id": "1004", "type": "Devil's Food" } ] }, "topping": [ { "id": "5001", "type": "None" }, { "id": "5002", "type": "Glazed" }, { "id": "5005", "type": "Sugar" }, { "id": "5007", "type": "Powdered Sugar" }, { "id": "5006", "type": "Chocolate with Sprinkles" }, { "id": "5003", "type": "Chocolate" }, { "id": "5004", "type": "Maple" } ] }, { "id": "0002", "type": "donut", "name": "Raised", "ppu": 0.55, "batters": { "batter": [ { "id": "1001", "type": "Regular" } ] }, "topping": [ { "id": "5001", "type": "None" }, { "id": "5002", "type": "Glazed" }, { "id": "5005", "type": "Sugar" }, { "id": "5003", "type": "Chocolate" }, { "id": "5004", "type": "Maple" } ] }, { "id": "0003", "type": "donut", "name": "Old Fashioned", "ppu": 0.55, "batters": { "batter": [ { "id": "1001", "type": "Regular" }, { "id": "1002", "type": "Chocolate" } ] }, "topping": [ { "id": "5001", "type": "None" }, { "id": "5002", "type": "Glazed" }, { "id": "5003", "type": "Chocolate" }, { "id": "5004", "type": "Maple" } ] } ]"""

        val parse = gson.fromJson<ParseModel>(json, ParseModel::class.java)


        val orderJson = """
            {"orderDTO":{"consumeType":"getGoodsCode","payType":6,"orderGoodsDetailList":[{"spbh":"002","spmc":"cs","spsl":1,"hdbh":"004"}],"order":{"jqbh":"1707600002","spsl":1,"dsfjybh":"220712160100022012","zffs":6,"zfzh":"904"}},"sign":"test1699425316464consumeType=hiTrade&dsfjybh=220712160100022012&jqbh=1707600002&qhm=&zfzh=904","consumeType":"hiTrade","key":2,"timestamp":1699425316464}
        """

        val orderParse = gson.fromJson(orderJson,OrderModel:: class.java)


        Log.e("OrderOutput", orderParse.toString())

        Log.e("consumerType",orderParse.consumeType)


        for (orderGoodsDetail in orderParse.orderDTO.orderGoodsDetailList) {
            Log.e("orderGood", orderGoodsDetail.toString())
        }

        Log.e("order",orderParse.orderDTO.order.toString())


        Log.e("sign",orderParse.sign)

        Log.e("timeStamp",orderParse.timestamp.toString())





        Log.e("TAG", "onCreate: "+ parse[0].toString() )
        for (parseModelItem in parse){
            Log.e("id",parseModelItem.id + "  "+ parseModelItem.name +" " +parseModelItem.batters.batter)

            for(batter in parseModelItem.batters.batter){
                Log.e("batters",batter.id + " " + batter.type)
            }

            for (topping in parseModelItem.topping){
                if (topping.type == "Glazed"){
                    Log.e("glazed",topping.type)
                }
                Log.e("topping",topping.id+ "  " + topping.type)
            }
        }



        val myData = MyData(1,"Khalid","Android")

        val order = Order("220712160100022012", "1707600002", 1, 6, "904")
        val orderGoodsDetailList = OrderGoodsDetail("004", "002", "cs", 1)
        val dto = OrderDTO("getGoodsCode", order, listOf(orderGoodsDetailList), 6)
        val orderModel = OrderModel("getGoodsCode", 2, dto, "test1699425316464consumeType=hiTrade&dsfjybh=220712160100022012&jqbh=1707600002&qhm=&zfzh=904", 1699425316464)

        val orderModelJson = gson.toJson(orderModel)

        Log.e("OrderModelJson",orderModelJson)


        val jsonString = gson.toJson(myData)

        Log.e("myData",jsonString)





    }
}
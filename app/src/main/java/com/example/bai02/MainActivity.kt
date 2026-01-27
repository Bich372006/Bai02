package com.example.affirmations.model

import kotlin.math.PI

// ===== LỚP TRỪU TƯỢNG =====
abstract class Dwelling(
    protected var residents: Int
) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

// ===== LỚP CON HOÀN CHỈNH =====
class SquareCabin(
    residents: Int,
    private val side: Double,
    private val floors: Int
) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return side * side * floors
    }

    // ===== DANH SÁCH =====
    private val residentsName = mutableListOf<String>()

    fun addResidents(vararg names: String) {
        for (name in names) {
            residentsName.add(name)
        }
    }

    fun printResidents() {
        for (name in residentsName) {
            println(name)
        }
    }

    // ===== STRING TEMPLATE =====
    fun info(): String {
        return "Material: $buildingMaterial, Area: ${floorArea()} m2"
    }
}

// ===== HÀM MAIN TEST CHẠY =====
fun main() {
    val squareCabin = SquareCabin(
        residents = 3,
        side = 6.0,
        floors = 2
    )

    squareCabin.addResidents("An", "Bình", "Chi")

    // ===== WITH =====
    with(squareCabin) {
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println(info())
        printResidents()
    }
}

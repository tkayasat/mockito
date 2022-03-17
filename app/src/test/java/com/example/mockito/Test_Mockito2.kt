package com.example.mockito

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


class Test_Mockito2 {
    @Mock
    var mcalc: ICalculator? = null
}

@RunWith(MockitoJUnitRunner::class)
class TestMockito {
    @Mock
    var mcalc: ICalculator? = null

    // используем аанотацию @InjectMocks для создания mock объекта
    @InjectMocks
    var calc = Calculator()

    @Test
    fun testCallMethod() {
        // определяем поведение (результаты)
        `when`(mcalc!!.subtract(15.0, 25.0)).thenReturn(10.0)
        `when`(mcalc!!.subtract(35.0, 25.0)).thenReturn(-10.0)

        // вызов метода subtract и проверка результата
        assertEquals(calc.subtract(15.0, 25.0), 10, 0)
        assertEquals(calc.subtract(15.0, 25.0), 10, 0)
        assertEquals(calc.subtract(35.0, 25.0), -10, 0)

        // проверка вызова методов
        verify(mcalc, atLeastOnce())!!.subtract(35.0, 25.0)
        verify(mcalc, atLeast(2))!!.subtract(15.0, 25.0)

        // проверка - был ли метод вызван 2 раза?
        verify(mcalc, times(2))!!.subtract(15.0, 25.0)
        // проверка - метод не был вызван ни разу
        verify(mcalc, never())!!.divide(10.0, 20.0)

    }

}

@Test
fun testSpy() {
    val scalc = spy(Calculator())
    `when`(scalc.double15()).thenReturn(23.0)

    // вызов метода реального класса
    scalc.double15()
    // проверка вызова метода
    verify(scalc).double15()

    // проверка возвращаемого методом значения
    assertEquals(23.0, scalc.double15(), 0)
    // проверка вызова метода не менее 2-х раз
    verify(scalc, atLeast(2)).double15()
}

fun assertEquals(d: Double, double15: Double, i: Int) {

}


fun assertEquals(subtract: Double, i: Int, i1: Int) {

}
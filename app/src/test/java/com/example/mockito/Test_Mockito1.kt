package com.example.mockito

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


class Test_Mockito1 {
    @Mock
    var mcalc: ICalculator? = null
}

@RunWith(MockitoJUnitRunner::class)
class TestMockito1 {
    @Mock
    var mcalc: ICalculator? = null

    // используем аанотацию @InjectMocks для создания mock объекта
    @InjectMocks
    var calc = Calculator()

    @Test
    fun testCalcAdd() {
        // определяем поведение калькулятора для операции сложения
        `when`(calc.add(10.0, 20.0)).thenReturn(30.0)

        // проверяем действие сложения
        assertEquals(calc.add(10.0, 20.0), 30.0, 0)
        // проверяем выполнение действия
        verify(mcalc)!!.add(10.0, 20.0)

        // определение поведения с использованием doReturn
        doReturn(15.0).`when`(mcalc)!!.add(10.0, 5.0)

        // проверяем действие сложения
        assertEquals(calc.add(10.0, 5.0), 15.0, 0)
        verify(mcalc)!!.add(10.0, 5.0)
    }

    private fun assertEquals(add: Double, d: Double, i: Int) {

    }
}
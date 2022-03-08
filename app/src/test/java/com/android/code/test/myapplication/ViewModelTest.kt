package com.android.code.test.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.android.code.test.myapplication.network.model.Info
import com.android.code.test.myapplication.network.repository.RetrofitRepository
import com.android.code.test.myapplication.network.viewmodel.ViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(MockitoJUnitRunner::class)
class ViewModelTest {

    private lateinit var viewModel: ViewModel

    @Mock
    lateinit var retrofitRepository: RetrofitRepository

    private lateinit var infoEmptyList:List<Info>
    private val mockList:MutableList<Info>  = mutableListOf()
    private val mockLiveData: MutableLiveData<List<Info>> = MutableLiveData<List<Info>>()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
        this.viewModel = ViewModel(this.retrofitRepository)
        mockData()
    }

    @Test
    fun fetchPostInfoFromRepositoryTest(){
        Mockito.`when`(retrofitRepository.fetchPostInfoList()).thenReturn(mockLiveData)
        viewModel.infoLiveData = mockLiveData
        Assert.assertNotNull(viewModel.infoLiveData.value)
        Assert.assertTrue(viewModel.infoLiveData.value?.size==3)

    }

    private fun mockData(){
        mockList.add(Info("Post Title1","Post Description1","1"))
        mockList.add(Info("Post Title2","Post Description2","2"))
        mockList.add(Info("Post Title3","Post Description3","3"))

        infoEmptyList= mockList.toList()

        mockLiveData.postValue(infoEmptyList)
    }
}
package com.guivillas.navegabilidadeentreastelas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.guivillas.navegabilidadeentreastelas.R
import com.guivillas.navegabilidadeentreastelas.data.model.Task
import com.guivillas.navegabilidadeentreastelas.databinding.FragmentTodoBinding
import com.guivillas.navegabilidadeentreastelas.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()

        initRecyclerViewTask(getTask())
    }

    private fun initListener() {
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initRecyclerViewTask(taskList: List<Task>){

        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)

        binding.recyclerViewTask.adapter = taskAdapter
    }

    private fun getTask() = listOf(
        Task(id = "0", description = "Criar nova tela do app"),
        Task(id = "1", description = "Validar informações na tela de login"),
        Task(id = "2", description = "Adicionar nova funcionalidade no app"),
        Task(id = "3", description = "Salvar token localmente"),
        Task(id = "2", description = "Criar funcionalidade de logout no app")
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
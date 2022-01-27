package io.twotle.sunrinapple

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.twotle.sunrinapple.databinding.ActivityMainBinding
import io.twotle.sunrinapple.model.Item
import io.twotle.sunrinapple.model.MemoItem
import io.twotle.sunrinapple.model.OnlyTitleItem
import io.twotle.sunrinapple.viewholder.MemoViewHolder
import io.twotle.sunrinapple.viewholder.OnlyTitleViewHolder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val adapter by lazy {
        BaseViewHolderFactory<Item>()
            .add<MemoItem>(
                MemoItem::class,
                MemoViewHolder.CREATOR,
                MemoViewHolder.DIFF
            ).add<OnlyTitleItem>(
                OnlyTitleItem::class,
                OnlyTitleViewHolder.CREATOR,
                OnlyTitleViewHolder.DIFF
            ).buildAdapter()
    }
    private val item by lazy {
        ArrayList<Item>().apply {
            (0..100).forEach { i->
                add(OnlyTitleItem("Title$i"))
                add(MemoItem("title$i","description$i"))
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recylerViewInit()
        adapter.submitList(item)
    }

    private fun recylerViewInit() {
        binding.rvMain.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }
}
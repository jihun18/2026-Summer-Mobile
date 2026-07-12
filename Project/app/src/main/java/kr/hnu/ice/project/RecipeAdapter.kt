package kr.hnu.ice.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
// ★ 아래 두 임포트 라인이 정확하게 들어가야 엉뚱한 자바 파일과 꼬이지 않습니다.
import kr.hnu.ice.project.databinding.ItemRecipeCardBinding

class RecipeAdapter(private val recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // 뷰바인딩 객체를 올바르게 참조하는 내부 ViewHolder 클래스
    class RecipeViewHolder(val binding: ItemRecipeCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = recipeList[position]

        holder.binding.ivRecipeImage.setImageResource(item.imageRes)
        // XML에 부여했던 ID를 통해 각각의 데이터를 매칭합니다.
        holder.binding.tvRecipeTitle.text = item.title
        holder.binding.tvRecipeRating.text = "${item.rating} (120)"
    }

    override fun getItemCount(): Int = recipeList.size
}
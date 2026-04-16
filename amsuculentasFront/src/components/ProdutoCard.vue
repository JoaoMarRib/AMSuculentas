<template>
  <v-card class="mx-auto" max-width="350">
    <v-img :src="imagem" height="200" cover />

    <v-card-title>{{ produto.nome }}</v-card-title>

    <v-card-text>
      <div v-if="produto.promocao > 0">
        <span class="preco-original">
          R$ {{ produto.preco }}
        </span>

        <div class="preco-desconto">
          R$ {{ precoComDesconto }}
        </div>
      </div>

      <div v-else>
        R$ {{ produto.preco }}
      </div>
    </v-card-text>
  </v-card>
</template>

<script setup lang="ts">
import { computed } from 'vue'

const props = defineProps<{
  produto: any
}>()

const imagem = computed(() => {
  if (!props.produto.imagem) return '/assets/produtosImg/sem-imagem.png'
  return props.produto.imagem.startsWith('/assets')
    ? props.produto.imagem
    : `/assets/produtosImg/${props.produto.imagem}`
})

const precoComDesconto = computed(() => {
  return (props.produto.preco * (100 - props.produto.promocao) / 100).toFixed(2)
})
</script>

<style scoped>
.preco-original {
  text-decoration: line-through;
  opacity: 0.7;
}

.preco-desconto {
  color: #00aa00;
  font-weight: bold;
  font-size: 1.2rem;
}
</style>
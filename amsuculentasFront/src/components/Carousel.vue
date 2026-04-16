<template>
  <v-carousel cycle hide-delimiter-background height="300">
    <v-carousel-item
      v-for="(produto, i) in produtos"
      :key="i"
    >
      <div class="d-flex justify-center">
        <ProdutoCard :produto="produto" />
      </div>
    </v-carousel-item>
  </v-carousel>
</template>

<script setup lang="ts">
import ProdutoCard from './ProdutoCard.vue'

defineProps<{
  produtos: any[]
}>()
</script>
<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import {
  detailArticle,
  deleteArticle,
  registComment,
  getComments,
  deleteComment,
  updateComment,
} from "@/api/board.js";
import { useAuth } from "@/hooks/useAuth";

const { currentUser } = useAuth();

const route = useRoute();
const router = useRouter();
const { articleno } = route.params;
const article = ref({});
const { comment } = defineProps(["comment"]);
const comments = ref({});
const replyContent = ref("");

onMounted(() => {
  getArticle();
});

const getArticle = () => {
  console.log(articleno + "번글 조회");
  detailArticle(
    articleno,
    ({ data }) => {
      article.value = data;
      console.log(data);
      getCommentsForArticle(article.value.articleno);
    },
    (error) => {
      console.log(error);
    }
  );
};

const getCommentsForArticle = () => {
  console.log(articleno + "번 댓글 조회");
  getComments(
    articleno,
    ({ data }) => {
      comments.value = data;
      console.log(data);
    },
    (error) => {
      console.log(error);
    }
  );
};

function registCommentsHandle() {
  const param = {
    article_no: articleno,
    comment: replyContent.value,
    user_id: currentUser.value.userid,
  };

  registComment(
    param,
    ({ data }) => {
      comments.value = data;
    },
    (error) => {
      console.log(error);
    }
  );

  replyContent.value = "";
}

function moveList() {
  router.push({ name: "article-list" });
}

function moveModify() {
  router.push({ name: "article-modify", params: { articleno } });
}

function onDeleteArticle() {
  // const { articleno } = route.params;
  console.log(articleno + "번글 삭제하러 가자!!!");
  // API 호출
  deleteArticle(
    articleno,
    ({ data }) => {
      (article.value = data), router.push({ name: "article-list" });
    },
    (error) => {
      console.log(error);
    }
  );
}

function onDeleteComment(comment) {
  console.log(comment.comment_no + "번 답글 삭제하자!!");
  console.log(comment);
  deleteComment(
    comment,
    ({ data }) => {
      comments.value = data;
      console.log(comment.comment_no);
      getCommentsForArticle(comment.article_no);
    },
    (error) => {
      console.log(error);
    }
  );
}

function onEditComment(comment) {
  comment.editing = true;
  comment.editedContent = comment.comment;
}

function onSubmitEdit(comment) {
  console.log(
    comment.comment_no + "번 댓글 수정 완료: " + comment.editedContent
  );
  comment.comment = comment.editedContent;
  comment.editing = false;
  updateComment(
    comment,
    ({ data }) => {
      comments.value = data;
      console.log(comment.comment_no);
      getCommentsForArticle(comment.article_no);
    },
    (error) => {
      console.log(error);
    }
  );
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글보기</mark>
        </h2>
      </div>
      <div class="col-lg-10 text-start">
        <div class="row my-2">
          <h2 class="px-5">{{ article.article_no }}. {{ article.subject }}</h2>
        </div>
        <div class="row">
          <div class="col-md-8">
            <div class="clearfix align-content-center">
              <img
                class="avatar me-2 float-md-start bg-light p-2"
                src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
              />
              <p>
                <span class="fw-bold">{{ article.user_id }}</span>
                <br />
                <span class="fw-light">
                  {{ article.register_time }}1 조회 : {{ article.hit }}
                </span>
              </p>
            </div>
          </div>
          <div class="col-md-4 align-self-center text-end">
            댓글 : {{ comments.length }}
          </div>
          <div class="divider mb-3"></div>
          <div class="text-secondary">
            {{ article.content }}
          </div>

          <div class="divider mt-3 mb-3"></div>
          <div style="display: flex; height: 100%">
            <v-textarea
              label="댓글을 달아주세요"
              rows="1"
              row-height="15"
              auto-grow
              variant="outlined"
              style="margin-right: 2%"
              v-model="replyContent"
            >
            </v-textarea>
            <button
              type="button"
              class="btn btn-outline-info mb-5"
              @click="registCommentsHandle"
            >
              입력
            </button>
          </div>

          <div class="table-responsive">
            <table class="table" style="width: 100%;">
              <tbody>
                <tr v-for="comment in comments" :key="comment.id">
                  <th>{{ comment.user_id }}</th>
                  <td>
                    <div v-if="comment.editing">
                      <v-textarea v-model="comment.editedContent"></v-textarea>
                      <button
                        type="button"
                        class="btn btn-outline-success mb-3 ms-1"
                        @click="onSubmitEdit(comment)"
                      >
                        완료
                      </button>
                    </div>
                    <div v-else>
                      <td>{{ comment.comment }}</td>
                      <td>{{ comment.register_time }}</td>
                      <td>
                        <button
                          type="button"
                          class="btn btn-outline-success mb-3 ms-1"
                          @click="onEditComment(comment)"
                        >
                          수정
                        </button>
                      </td>
                      <td>
                        <button
                          type="button"
                          class="btn btn-outline-danger mb-3 ms-1"
                          style="color: red;"
                          @click="onDeleteComment(comment)"
                        >
                          삭제
                        </button>
                      </td>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>

          <div class="d-flex justify-content-end">
            <button
              type="button"
              class="btn btn-outline-primary mb-3"
              @click="moveList"
            >
              글목록
            </button>
            <button
              type="button"
              class="btn btn-outline-success mb-3 ms-1"
              @click="moveModify"
            >
              글수정
            </button>
            <button
              type="button"
              class="btn btn-outline-danger mb-3 ms-1"
              @click="onDeleteArticle"
            >
              글삭제
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>

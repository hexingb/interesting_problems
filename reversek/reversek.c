/**
 * reversek.c - reverse every k nodes in a singly linked list
 *
 * Author: Bao Hexing <HexingB@qq.com>
 * Created: 19 July 2019
 *
 * Copyright © 2019, Bao Hexing. All Rights Reserved.
 */

#include <stdio.h>
#include <stdlib.h>

struct ListNode {
  int id;
  struct ListNode *next;
};

static struct ListNode *reverse_k(struct ListNode *list, size_t k) {
  struct ListNode *head = NULL;
  struct ListNode **ptail = &head;
  struct ListNode **psegment_tail = NULL;

  while (list != NULL) {
    psegment_tail = &list->next;

    struct ListNode *segment_head = NULL;
    for (size_t i = 0; i < k && list != NULL; ++i) {
      struct ListNode *node = list;
      list = list->next;

      node->next = segment_head;
      segment_head = node;
    }

    *ptail = segment_head;
    ptail = psegment_tail;
  }
  return head;
}

static struct ListNode *create_list(int count) {
  struct ListNode *list = NULL;
  struct ListNode **ptail = &list;

  for (int i = 1; i <= count; ++i) {
    struct ListNode *node = (struct ListNode *)malloc(sizeof(struct ListNode));
    // check node != NULL
    node->id = i;
    node->next = NULL;
    *ptail = node;
    ptail = &node->next;
  }
  return list;
}

static void display_list(struct ListNode *list) {
  while (list != NULL) {
    fprintf(stdout, "%d -> ", list->id);
    list = list->next;
  }
  fprintf(stdout, " NULL\n");
}

static void destroy_list(struct ListNode *list) {
  struct ListNode *head = NULL;
  while (list != NULL) {
    head = list;
    list = list->next;
    free(head);
  }
}

int main(int argc, char *argv[]) {
  struct ListNode *list = create_list(5);
  display_list(list);
  list = reverse_k(list, 2);
  display_list(list);
  destroy_list(list);
  return 0;
}


#include <sys/time.h>
#include <time.h>
#include <stdlib.h>
#include <stdint.h>



struct periodic_task {
  struct timespec r;
  int period;
};

#define NSEC_PER_SEC 1000000000ULL



static inline void timespec_add_us(struct timespec *t, uint64_t d);
void wait_next_activation(struct periodic_task *t);
struct periodic_task *start_periodic_timer(uint64_t offs, int t);
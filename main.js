// const obj = {
//   count: 10,
//   inc: function () {
//     setTimeout(() => {
//       this.count++;
//       console.log(this.count);
//     }, 100);
//   }
// };
// obj.inc();

// console.log('start');

// setTimeout(() => {
//   console.log('timeout');
// }, 0);

// Promise.resolve().then(() => {
//   console.log('promise');
// });

// console.log('end');
// async function f1() {
//   throw 'Error in f1';
// }

// async function f2() {
//   try {
//     await f1();
//   } catch (e) {
//     console.log('Caught: ', e);
//   } finally {
//     return 'Done';
//   }
// }

// f2().then(console.log);
// for (let i = 0; i < 3; i++) {
//   setTimeout(() => console.log(i), 100);
// }

// function outer() {
//   var funcs = [];
//   for (var i = 0; i < 3; i++) {
//     funcs.push(function () {
//       console.log(i);
//     });
//   }
//   return funcs;
// }

// const results = outer();
// results[0]();
// results[1]();
// results[2]();
// const obj = {
//   count: 0,
//   inc: function () {
//     setTimeout(function () {
//       this.count++;
//       console.log(this.count);
//     }, 100);
//   }
// };
// obj.inc();


// function add(x){
//     return function(y){
//         return x + y;
//     }
// }


// console.log(add(2)(3)) 
// function counter() {
//   let count = 0;
//   return {
//     inc: () => ++count,
//     dec: () => --count
//   };
// }

// const a = counter();
// const b = counter();

// a.inc(); a.inc();
// b.inc();
// console.log(a.dec(), b.dec());
// let obj = {
//   valueOf() {
//     return {};
//   },
//   toString() {
//     return "5";
//   }
// };
// console.log(obj);
// console.log(obj == 5);
// console.log(obj === 5);
        
// function A() {}
// A.prototype.value = 1;

// const a1 = new A();
// A.prototype = { value: 2 };

// const a2 = new A();

// console.log(a1.value, a2.value);

// async function* gen() {
//   yield await Promise.resolve(1);
//   yield 2;
// }

// (async () => {
//   for await (const val of gen()) {
//     console.log(val);
//   }
// })();
console.log('start');

setTimeout(() => console.log('timeout 1'), 0);

Promise.resolve().then(() => {
  console.log('promise 1');
  setTimeout(() => console.log('timeout 2'), 0);
});

queueMicrotask(() => console.log('microtask'));

console.log('end');
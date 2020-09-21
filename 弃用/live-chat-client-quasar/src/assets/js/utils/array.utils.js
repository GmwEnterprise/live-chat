/**
 *
 * @param {Array} array
 * @param {*} element
 */
export function moveElementToHead(array, element) {
  for (const [index, item] of array.entries()) {
    if (item === element) {
      array.splice(index, 1);
      break;
    }
  }
  array.unshift(element);
}

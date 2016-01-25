export function getCookieValue(name) {
    let matchedValue = document.cookie.match(new RegExp(name + '=([^;]+)'));
    if (matchedValue) {
        return matchedValue[1];
    }
}
package druidsurv.cards;

import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.cardvars.CardTags;

import static druidsurv.ModFile.makeID;

public class DartMonkey extends AbstractEasyCard {
    public final static String ID = makeID("DartMonkey");
    // intellij stuff attack, enemy, basic, 6, 3,  , , , 

    public DartMonkey() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 4;
        tags.add(CardTags.STRIKE);
        tags.add(CardTags.STARTER_STRIKE);
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}
package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.zerodelaybloon;

import static druidsurv.ModFile.makeID;

public class PinkBloon extends AbstractEasyCard {
    public final static String ID = makeID("PinkBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public PinkBloon() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseBlock = 0;
        baseDamage = 10;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new zerodelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        blck();
    }

    @Override
    public void upp() {
        upgradeBlock(5);
    }
}